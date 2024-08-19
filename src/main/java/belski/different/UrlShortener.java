package belski.different;

public class UrlShortener {

    public String idToShortURL(int id) {
        final char map[] = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

        StringBuffer shorturl = new StringBuffer();

        while (id > 0) {
            shorturl.append(map[id % 36]);
            id = id / 36;
        }

        return shorturl.reverse().toString();
    }

    public int shortURLtoID(String shortURL) {
        int id = 0;

        for (int i = 0; i < shortURL.length(); i++) {
            if ('a' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'z')
                id = id * 36 + shortURL.charAt(i) - 'a';
            if ('0' <= shortURL.charAt(i) && shortURL.charAt(i) <= '9')
                id = id * 36 + shortURL.charAt(i) - '0' + 26;
        }
        return id;
    }
}
