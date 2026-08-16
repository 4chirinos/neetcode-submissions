class TimeMap {

    // Analysis:
    // Let's hold the data in a Map<String, <List<Entry>>>
    // Entry will be a class with two properties: value and timestamp
    // Set operation behaves like this:
    // 1. upsert Map for that specific key by adding the new entry to its list
    // Get operation behaves like this:
    // 1. Apply binary search to speed up the search

    private static class Entry {
        String value;
        int timestamp;
        public Entry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Entry>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Entry entry = new Entry(value, timestamp);
        if (store.containsKey(key)) {
            store.get(key).add(entry);
        } else {
            List<Entry> entries = new ArrayList<Entry>();
            entries.add(entry);
            store.put(key, entries);
        }
    }
    
    public String get(String key, int timestamp) {
        List<Entry> entries = store.get(key);
        if (entries == null) {
            return "";
        }
        int low = 0;
        int high = entries.size() - 1;
        String newestValue = "";
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (entries.get(mid).timestamp == timestamp) {
                return entries.get(mid).value;
            } else if (entries.get(mid).timestamp < timestamp) {
                newestValue = entries.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return newestValue;
    }
}
