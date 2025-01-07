package singleton;

/*
- JVM đảm bảo rằng các biến static của một lớp sẽ được khởi tạo khi lớp đó được load lần đầu tiên.
- Tuy nhiên, một inner static class sẽ không được load cho đến khi nó được tham chiếu đến lần đầu tiên.
- Trong trường hợp này, SingletonHelper (và do đó INSTANCE) sẽ không được load cho đến khi phương thức
getInstance() của BillPughSingleton được gọi. Đây chính là cơ chế lazy initialization.
- JVM đảm bảo rằng quá trình khởi tạo một lớp (bao gồm khởi tạo các biến static) là an toàn luồng.

Khi SingletonHelper được load (khi getInstance() được gọi lần đầu), JVM sẽ đảm bảo rằng chỉ có một luồng duy nhất thực
hiện việc khởi tạo INSTANCE. Các luồng khác sẽ bị chặn cho đến khi quá trình khởi tạo hoàn tất.
 */

public class BillPughSingleton {
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
}
