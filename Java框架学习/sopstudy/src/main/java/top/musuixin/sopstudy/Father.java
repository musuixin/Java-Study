package top.musuixin.sopstudy;

public class Father{
    Mom get(Mom mom) {
        mom.doWork();
        return new Mom();
    }
}

