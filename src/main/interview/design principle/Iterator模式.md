#Iterator模式
使用Java语言显示数组arr中的元素时，我们可以使用下面这样的for循环遍历数组。
```java
for(int i = 0; i < arr.legth; i ++){
    System.out.pringln(arr[i]);
}
```
请注意这段代码中的循环变量i。该变量的初始值是0，然后会递增为1，2，3，，，，程序则在每次i递增后都输出arr[i]。我们程序中经常会看到这样的for语句。  
数组中保存了很多元素，通过指定数组下标，我们可以从中选中任一元素。  
arr[0] 最开始的元素
for语句中的i++ 的作用是让i的值在每次循环后自增一。  
将这里的循环变量i的作用抽象化，通用化后形成的模式，在设计模式中称为Iterator模式。  
Iterator模式用于在数据集合中按照顺序遍历集合。英文单词Iterator有反复做某件事的意思。汉语称为"迭代器"。

###示例程序
作用：将书（book）放置到书架（bookShelf）中，并将书的名字按顺序显示出来。

###Iterator模式中的登场角色

- Iterator（迭代器）  
该角色负责定义按顺序逐个遍历元素的接口（API）。定义了hasNext和next两个方法。其中hasNext方法用于判断是否存在下一个元素，next方法用于获取该元素。  
- Concretelterator（具体的迭代器）  
该角色负责实现Iterator角色所定义的接口（API）。  
- 

###拓展思路的要点  

####不管实现如何变化，都可以使用Iterator  
为什么一定要考虑引入Iterator这种复杂的设计模式呢？如果是数组，直接使用for循环语句进行遍历处理不就可以了吗？为什么要在集合之外引入Iterator这个角色呢？  
一个重要的理由是，引入Iterator可以将遍历与实现分离开来。
```java
while(it.hasNext()){
    Book book = (Book)it.next();
    System.out.println(book.getName());
}
```  
这里只使用了Iterator的hasNext和next方法，并没有调用BookShelf的方法。这里的while循环并不依赖与BookShelf的实现。  
这对于BookShelf的调用者来说真的是太方便了。设计模式的作用就是帮助我们编写可复用的类。所谓"可复用"，就是指将类实现为"组件"，当一个组件发生改变时，不需要对其它组件进行修改或是只需要进行很小的修改就可以应对。


###相关的设计模式   

- Visitor模式  
Iterator模式是从集合中一个一个取出元素进行遍历，但是并没有在Iterator接口中声明对取出的元素进行何种处理。  
Visitor模式则是在遍历元素集合的过程中，对元素进行相同的处理。  
在遍历集合的过程中对元素进行固定的处理是常有的需求。Visigtor模式正是为了应对这种需求而出现的。在访问元素集合的过程中对元素进行相同的处理，这种模式就是visitor模式。  
- Composite模式  
Composite模式是具有递归结构的模式，在其中使用Iterator模式比较困难。  
- Factroy Method模式  
在iterator方法中生成Iterator的实例可能会使用Factory Method模式。  
测试提交