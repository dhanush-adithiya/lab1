import java.util.Scanner;

public class Lab1 {
    public String ccNumber;

    public Lab1(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String IsValidCard() {
        if (this.ccNumber.length() >= 8 && this.ccNumber.length() <= 9) {
            return "Valid";
        } else  {
            return "Invalid";
        }
    }

    public void ValidateCard() {
        String valid = IsValidCard();
        switch (valid) {
            case "Valid" -> {
                String strippedLast = this.ccNumber.substring(0, this.ccNumber.length() - 1);
                int last = this.ccNumber.charAt(this.ccNumber.length() - 1) - '0';
                String reverse = new StringBuilder(strippedLast).reverse().toString();
                int sum = 0;
                for (int i = 0; i < reverse.length(); i++) {
                    if (i % 2 == 0) {
                        int doubDigit = reverse.charAt(i) - '0' + reverse.charAt(i) - '0';
                        if (doubDigit >= 10) {
                            String doub = String.valueOf(doubDigit);
                            int doubSum = doub.charAt(0) - '0' + doub.charAt(1) - '0';
                            sum += doubSum;
                        } else {
                            sum += doubDigit;
                        }
                    } else {
                        sum += reverse.charAt(i) - '0';
                    }

                }
                int sumLast = String.valueOf(sum).charAt(1) - '0';
                if (sumLast == last) {
                    System.out.println("Card Is Valid");
                } else {
                    System.out.println("Card Is Invalid");
                }
            }
            case "Invalid" -> {
                System.out.println("Card Is Invalid");
            }
        }

    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter CardNumber");

        String cardNumber = inp.nextLine();  // Read user input
        Lab1 validateCard = new Lab1(cardNumber);
        validateCard.ValidateCard();
    }
}