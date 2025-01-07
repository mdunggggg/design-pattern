package factory_method;


public class BankFactory {

    public static void main(String[] args) {
        try {
            Bank bank = BankFactory.getBank(BankType.VIETCOMBANK);
            System.out.println(bank.getName());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static Bank getBank(BankType type) throws Exception{
        return switch (type) {
            case MBBANK -> new MBBank();
            case VIETCOMBANK -> new VietcomBank();
        };
    }

}

abstract class Bank {
    public abstract String getName();
}

enum BankType {
    MBBANK,
    VIETCOMBANK,
}

class MBBank extends  Bank {

    @Override
    public String getName() {
        return "MBBank";
    }
}

class VietcomBank extends Bank {

    @Override
    public String getName() {
        return "VietcomBank";
    }
}