new Vue({
    el: '#main-container',
    data: {
        pageInfo: {
            current: 1,
            size: 5
        },
        app: {
            platform: 0,
            forceUpdate: 0
        },
        active: false
    },
    methods: {
        select: function (pageNum, pageSize) {
            axios({
                url: '/manager/app/select',
                params: {
                    current: pageNum,
                    size: pageSize
                }
            }).then(response => {
                this.pageInfo = response.data.data;
            }).catch(function (error) {
                console.log(error);
            });
        },
        save: function () {
            axios({
                url: '/manager/app/saveOrUpdate',
                method: 'POST',
                data: this.app
            }).then(response => {
                if (response.data.code == 200) {
                    //更新表格
                    this.select(this.pageInfo.current, this.pageInfo.size);
                    this.app = {
                        platform: 0,
                        forceUpdate: 0
                    }
                }
                //弹提示消息框
                layer.msg(response.data.msg);
            });
        },
        toUpdate: function (id) {
            axios({
                url: '/manager/app/selectOne/'+id,
                method: 'POST',
            }).then(response => {
                if (response.data.code != 200) {
                    layer.msg(response.data.msg);
                    return;
                }
                layer.appVersion = response.data.data;
                console.log(layer);
                //打开layer所在页面
                let index = layer.open({
                    type: 2, //类型：0信息框  1 页面层  2 iframe层  3 加载层  4 tips层
                    title: '更新app',
                    content: '/manager/app/app-update.html',
                    area: ['60%', '80%'],
                    end: () => {
                        this.select(this.pageInfo.current, this.pageInfo.size);
                    }
                });
            });
        },
        doDelete: function (id) {
            layer.msg('是否删除?', {
                //无自动消失计时
                time: 0,
                btn: ['是', '否'],
                yes: index => {
                    axios({
                        url: '/manager/app/delete/'+id,
                        method: 'POST',
                    }).then(response => {
                        //关闭当前窗口
                        layer.close(index);
                        layer.msg(response.data.msg);
                        //刷新数据列表
                        if (response.data.code == 200) {
                            this.select(this.pageInfo.current, this.pageInfo.size);
                        }
                    });
                }
            });
        }
    },
    created: function () {
        this.select(this.pageInfo.current, this.pageInfo.size);
    }
})