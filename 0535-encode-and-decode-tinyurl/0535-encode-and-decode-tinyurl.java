public class Codec {
    private final Map<Integer, String> map = new HashMap<>();
    private int counter = 0;

    public String encode(String longUrl) {
        map.put(++counter, longUrl);
        return "http://tinyurl.com/" + counter;
    }

    public String decode(String shortUrl) {
        int id = Integer.parseInt(shortUrl.substring(shortUrl.lastIndexOf('/') + 1));
        return map.get(id);
    }
}