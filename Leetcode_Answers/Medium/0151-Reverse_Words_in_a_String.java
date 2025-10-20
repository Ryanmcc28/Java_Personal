class Solution {
    public String reverseWords(String s) {

        String[] wordArray = s.split(" ");
        String[] answerArray = new String[wordArray.length];
        int count = 0;
        String answer = "";

        for (int i = wordArray.length - 1; i >= 0; i--) {
            answer = answer + wordArray[i] + " ";
        }

        char[] ansArray = answer.trim().toCharArray();
        answer = "";
        answer += ansArray[0];

        for (int i = 1; i < ansArray.length; i++) {
            if (ansArray[i - 1] == ' ' && ansArray[i] == ' ') {
                continue;
            } else {
                answer += ansArray[i];
            }
        }
        return answer;
    }
}
