import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Lab1Test2 {
    private Lab1 lab;

    @Before
    public void setUp() {
        lab = new Lab1();
        // 构建测试图（带权重）
        lab.addEdge("a", "b", 1);
        lab.addEdge("b", "c", 2);
        lab.addEdge("c", "d", 3);
        lab.addEdge("d", "e", 4);
        lab.addEdge("a", "d", 5); // 直接路径，但权重更高
    }
    /*public void setUp() {
        lab = new Lab1();
        // 构建测试图：a→b, a→c, b→d, c→d, d→e
        lab.readFromFile("C:\\Users\\59395\\IdeaProjects\\lab1\\src\\test2.txt"); // 提前准备包含测试数据的文件
    }*/

    // 测试用例1：存在最短路径
    @Test
    public void testCalcShortestPath_ExistingPath() {
        String expected = "Shortest path from \"a\" to \"d\" is: a -> d\nTotal weight: 5";
        String result = lab.calcShortestPath("a", "d");
        assertEquals(expected, result);
    }

    // 测试用例2：起点不存在
    @Test
    public void testCalcShortestPath_StartNotExist() {
        String expected = "No x or d in the graph!";
        String result = lab.calcShortestPath("x", "d");
        assertEquals(expected, result);
    }

    // 测试用例3：终点不存在
    @Test
    public void testCalcShortestPath_EndNotExist() {
        String expected = "No a or z in the graph!";
        String result = lab.calcShortestPath("a", "z");
        assertEquals(expected, result);
    }

    // 测试用例4：起点和终点相同
    @Test
    public void testCalcShortestPath_SameNode() {
        String expected = "Shortest path from \"a\" to \"a\" is: a\nTotal weight: 0";
        String result = lab.calcShortestPath("a", "a");
        assertEquals(expected, result);
    }

    // 测试用例5：路径不存在
    @Test
    public void testCalcShortestPath_PathNotExist() {
        String expected = "There is no path from e to a.";
        String result = lab.calcShortestPath("e", "a");
        assertEquals(expected, result);
    }

    // 测试用例6：多条路径选择最短
    @Test
    public void testCalcShortestPath_MultiplePaths() {
        String expected = "Shortest path from \"a\" to \"e\" is: a -> d -> e\nTotal weight: 9";
        String result = lab.calcShortestPath("a", "e");
        assertEquals(expected, result);
    }

    // 测试用例7：处理权重为0的边
    @Test
    public void testCalcShortestPath_ZeroWeightEdge() {
        lab.addEdge("d", "e", 0); // 覆盖权重为0的情况
        String expected = "Shortest path from \"a\" to \"e\" is: a -> d -> e\nTotal weight: 5";
        String result = lab.calcShortestPath("a", "e");
        assertEquals(expected, result);
    }

    // 测试用例8：验证Dijkstra算法（优先选择权重小的路径）
    @Test
    public void testCalcShortestPath_Dijkstra() {
        lab.addEdge("a", "c", 10); // 添加替代路径 a→c→d (权重13)
        String expected = "Shortest path from \"a\" to \"d\" is: a -> d\nTotal weight: 5";
        String result = lab.calcShortestPath("a", "d");
        assertEquals(expected, result);
    }
}