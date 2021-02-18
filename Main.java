/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the
   standard library */

/* Do not add a namespace declaration */

public class Main {
    public static List<String> processData(ArrayList<String> array) {
        /*
         * Modify this method to process `array` as indicated
         * in the question. At the end, return a List containing the
         * appropriate values
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */
        class Customer {
            private String customerName;
            private String storeLocation;
            private String date;
            private String productName;
            private int price;
            private String paymentType;

            public Customer(String item) {
                String[] itemColumns = item.split("\\s*,\\s*");
                this.customerName = itemColumns[0];
                this.storeLocation = itemColumns[1];
                this.date = itemColumns[2];
                this.productName = itemColumns[3];
                this.price = Integer.parseInt(itemColumns[4].replace("Rs ", ""));
                this.paymentType = itemColumns[5];
            }

            public String getCustomerName() {
                return customerName;
            }

            public int getPrice() {
                return price;
            }

            public String getProductName() {
                return productName;
            }
        }

        List<Customer> customerList = new ArrayList<Customer>();
        Iterator itr = array.iterator();
        while(itr.hasNext()){
            String item = (String) itr.next();
            customerList.add(new Customer(item));
        }

        String[] productsOnDiscount = {"Samsung Battery", "Earphones", "USB cable"};
        Optional<Customer> filterSortedProducts = null;
        List<String> retVal = new ArrayList<String>();
        for (String productName : productsOnDiscount) {
            filterSortedProducts = customerList.stream()
                    .filter(cust -> cust.getProductName().equalsIgnoreCase(productName))
                    .sorted(Comparator.comparing(Customer::getPrice))
                    .findFirst();
            retVal.add(filterSortedProducts.get().getCustomerName());
        }
        return retVal;
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine())
            inputData.add(in.nextLine());
        List<String> retVal = processData(inputData);
        PrintWriter output = new PrintWriter(System.out);
        for(String str: retVal)
            output.println(str);
        output.close();
    }
}
