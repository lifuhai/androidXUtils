package com.lfh.first.contract;

public interface MainContract {
    interface Model {

    }

    interface View {
        void getNetDataSuccess(String success);

    }

    interface Presenter {
        void getNetData(String s);
    }
}
