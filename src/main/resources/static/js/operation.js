/**
 * Created by yuecheng on 2017/7/21.
 */


var userName = 'admin';
var userAge = 24;
var userId = 0;
function findAll() {
    $.ajax({
        type: 'get',
        dataType: 'json',
        url: "findAll",
        error: function () {
            alert('fail');
        },
        success: function (data) {
            // alert('success');
            for (var i = 0; i < data.length; i++) {
                mygrid.addRow(i + 1, [data[i].userId, data[i].userName, data[i].userAge]);
            }
        }
    });
}

function doAdd() {
    mygrid.addRow(mygrid.getRowsNum(), {});
}

function doDelete() {
    userId = mygrid.cells(mygrid.getSelectedRowId(), "0").getValue();
    $.ajax({
        type: 'post',
        data: {'id': userId},
        dataType: 'json',
        url: 'delete',
        success: function (data) {
            mygrid.clearAll();
            for (var i = 0; i < data.length; i++) {
                mygrid.addRow(i + 1, [data[i].userId, data[i].userName, data[i].userAge]);
            }
        },
        error: function () {
            alert('delete fail');
        }
    })
}

function onEnter() {
    userId = mygrid.cells(mygrid.getSelectedRowId(), "0").getValue();
    userName = mygrid.cells(mygrid.getSelectedRowId(), "1").getValue();
    userAge = mygrid.cells(mygrid.getSelectedRowId(), "2").getValue();
    $.ajax({
        type: 'post',
        data: {"id": userId, "name": userName, "age": userAge},
        dataType: 'json',
        url: 'update',
        success: function (data) {
            mygrid.clearAll();
            for (var i = 0; i < data.length; i++) {
                mygrid.addRow(i + 1, [data[i].userId, data[i].userName, data[i].userAge]);
            }
        },
        error: function () {
            alert('fail');
        }
    })

}