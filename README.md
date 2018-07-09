# Android Paging Library 正負數範例

[Medium](https://medium.com/p/aaf2e74dd546/edit)

## 使用Android Paging Library展示一個正負數的無限列表

### ItemKeyedDataSource
使用時機：當RecyclerView資料Item的Key有連續性，可根據資料的Key找到上一筆或下一筆資料

### PageKeyedDataSource 
使用時機：原始資料來源（遠端Server或其他資料來源）已有分頁功能，根據每頁的Key取得資料

### PositionalDataSource
使用時機：根據RecyclerView的絕對位置決定放資料