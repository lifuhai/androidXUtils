# mvp+组件化开发+常用的一些工具类
组件化之间跳转用的阿里路由方式跳转、
封装了一些常用工具类集合、吐司、预加载view 、 万能适配器 等

#预加载view   base里面封装此方法

    public void hold(int id) {
        mVaryViewHelper = new VaryViewHelper.Builder()
                .setDataView(findViewById(id))//放数据的父布局，逻辑处理在该Activity中处理
                .setLoadingView(LayoutInflater.from(this).inflate(R.layout.layout_loadingview, null))//加载页，无实际逻辑处理
                .setEmptyView(LayoutInflater.from(this).inflate(R.layout.layout_emptyview, null))//空页面，无实际逻辑处理
                .setErrorView(LayoutInflater.from(this).inflate(R.layout.layout_errorview, null))//错误页面
                .build();
        mVaryViewHelper.mErrorView.findViewById(R.id.vv_error_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
    }

# activity引用   fragment同样适用
     hold(R.id.linear);//绑定view
         mVaryViewHelper.showLoadingView();//预加载
            mVaryViewHelper.showErrorView(R.drawable.bg_btn);
            mVaryViewHelper.showEmptyView("11111");



