public class Grader {
    public char letterGrade(String creditText, String marksText) {
        int credit = Integer.parseInt(creditText);
        double marks = Double.parseDouble(marksText);

        double roundedUpMarks = Math.ceil(marks);

        if(marks < 0) {
            throw new IllegalArgumentException("Marks should be greater than 0\n" +
                    "instead got " + marks);
        }
        else if (marks > 400) {
            throw new IllegalArgumentException("Marks should be smaller or equals to 400\n" +
                    "instead got " + marks);
        }

        if(credit == 3) {
            if(roundedUpMarks < 180) return 'F';
            else if (roundedUpMarks < 210) return 'C';
            else if (roundedUpMarks < 240) return 'B';
            else return 'A';
        } else if (credit == 4) {
            if(roundedUpMarks < 240) return 'F';
            else if (roundedUpMarks < 280) return 'C';
            else if (roundedUpMarks < 320) return 'B';
            else return 'A';
        } else {
            throw new IllegalArgumentException("Credit should be 3 or 4\n" +
                    "instead got " + credit);
        }
    }
}
