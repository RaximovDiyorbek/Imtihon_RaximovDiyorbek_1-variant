public class Task3 {
    public static void main(String[] args) {
        String[] arrays = {"cd","ac","dc","zz","ca"};

        System.out.println(task3(arrays));
    }

    public static int task3(String[] words){
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (reverseWords(words[i]).equals(words[j])){
                    count++;
                }
            }
        }

        return count;
    }

    public static String reverseWords(String word){
        StringBuilder sb = new StringBuilder(word);

        return sb.reverse().toString();

    }
}
