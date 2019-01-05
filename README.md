## Android Paging Library 正負數範例，展示一個正負數的類無限列表

### 效果顯示

![go up](https://github.com/HankLi0130/PagingDemo/blob/master/images/go_up.gif) &nbsp;&nbsp;&nbsp;&nbsp; ![go down](https://github.com/HankLi0130/PagingDemo/blob/master/images/go_down.gif)

### 文章講解

[Android 無限列表，RecyclerView 搭配 Android Paging Library](https://medium.com/@hankli0130/android-paging-library-%E5%88%9D%E6%8E%A2datasource-aaf2e74dd546)

## 各 DataSource 使用時機

### ItemKeyedDataSource
使用時機：當RecyclerView資料Item的Key有連續性，可根據資料的Key找到上一筆或下一筆資料

### PageKeyedDataSource 
使用時機：原始資料來源（遠端Server或其他資料來源）已有分頁功能，根據每頁的Key取得資料

### PositionalDataSource
使用時機：根據RecyclerView的絕對位置決定放資料
