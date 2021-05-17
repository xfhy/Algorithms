
BFS(广度优先搜索)算法框架如下:

```java
//计算从起点start到终点target的最短距离
int BFS(Node start, Node target) {
    //核心数据结构
    Queue<Node> q;
    //避免走回头路
    Set<Node> visited;

    //将起点加入
    q.offer(start);
    visited.add(start);
    //记录扩散的步数
    int step = 0;

    while (q not empty){
        int sz = q.size();
        //将当前队列中的所有节点向四周扩散
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();
            //判断是否已经到达终点
            if (cur is target)return step;
            //将cur相邻节点加入队列
            for (Node x : cur.adj()) {
                if(x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
            }
        }
        //!!!更新步数
        step++;
    }
}
```