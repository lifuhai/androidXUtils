package com.lfh.utils.contract;

import java.util.List;

/**
 * created by lfh
 * on 2020/12/11
 */

public interface IMvpTest {


    interface View {
        void successGetDetail(Object data);

        void failReason(String fail);
    }

    interface Presenter {

        void onClick(String json);
    }
}
