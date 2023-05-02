public class Practice {
    public static void main(String args[]){
        int first = 1, second = 20;
        int small = Math.min(first, second);
        int big = Math.max(first, second);

        for (int i = small; i <= big; i++)
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("usbdevice");
            } else if(i % 3 == 0){
                System.out.println("usb");
            } else if(i % 5 == 0 ) {
                System.out.println("device");
            } else
                System.out.println(i);
        }
    }
