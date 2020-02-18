# 组合模式

>组合模式：将对象组合成树形结构来表现“整体/部分”层次结构。组合能让客户以一致的方式处理个别对象以及对象组合。

共有 3 种角色：

1. 组件：定义叶节点和组合的通用方法
2. 个别对象：叶节点，菜单项，继承组件
3. 对象组合：节点，菜单，继承组件。可以包含组合和个别对象。

菜单组合，维护了一个集合，里面既可以是自己（节点），也可以是菜单项（叶子），如此便可以形成一棵树。

![组合模式类图](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/8B2546A797644409B5E7A56D24187C0E/14298)

## 案例

餐厅中的菜单包含多个菜单项，也可能包含子菜单。菜单作为节点，菜单项作为叶子节点，形成一棵树。如何设计，可以让我们用相同的方式遍历父菜单、菜单项和子菜单呢？从而忽略对象组合和个别对象之间的差异。

![组合模式案例](https://note.youdao.com/yws/public/resource/fb63e88819e0de2bc8a59f7f002e0843/xmlnote/A9731C3FE9124A33B7F650325B5336FF/14306)

## 组合与空迭代器

如果一个对象没有维护一个可以迭代的集合，那么就它的 createIterator() 方法可以有两种实现

1. 返回 null，这样在遍历时需要对迭代器进行非空判断
2. 返回一个迭代器，但这个迭代器的 next() 方法返回 null，hasNext() 返回 false。

```java
public class NullIterator implements Iterator {
    public Object next() { return null; }
    public boolearn hasNext() { return false; }
}
```