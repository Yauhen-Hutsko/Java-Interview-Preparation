/**
 * Coderbyte — Matching Characters.
 * For every pair of equal characters, count the distinct characters between them;
 * return the maximum such count as a string.
 * <p>
 * Two solutions:
 * - {@link #matchingCharacters}  — resolved, speed O(n^2) / memory O(n).
 * - {@link #matchingCharacters2} — resolved, speed O(n^3) / memory O(n).
 */
class MatchingCharacters {

    static void main(String[] args) {
        IO.println(matchingCharacters2("abcdefeb"));  //4
        IO.println(matchingCharacters2("qwwwertaaaaaowhe")); //6
    }

    static String matchingCharacters2(String str){
        if (str == null || str.isBlank()) {
            return "0";
        }
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j < str.length(); j++) {
                if (str.charAt(j) == str.charAt(i)) {
                    String btw = str.substring(i+1, j);
                    int count = (int)btw.chars().distinct().count();
                    result = Math.max(result, count);
                }

            }
        }

        return String.valueOf(result);
    }

    static String matchingCharacters(String str){
        if (str == null || str.isBlank()){
            return "0";
        }
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int lastOccurrence = str.lastIndexOf(str.charAt(i));
            if (lastOccurrence <= i+1) {
                continue;
            }

            int count = (int)str.substring(i+1, lastOccurrence).chars().distinct().count();
            result = Math.max(result, count);
//            Set<Character> unique = new HashSet<>();
//            for (int j = i+1; j<lastOccurrence; j++){
//                unique.add(str.charAt(j));
//            }
//            result = Math.max(result, unique.size());
        }
        return String.valueOf(result);
    }
}
