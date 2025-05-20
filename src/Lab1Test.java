import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Lab1Test {
    private Lab1 lab; // 被测对象

    // 初始化：在每个测试方法前构建测试图
    @Before
    public void setUp() {
        lab = new Lab1();
        // 构建测试图：a→b, a→c, b→d, c→d, d→e
        lab.readFromFile("C:\\Users\\59395\\IdeaProjects\\lab1\\src\\test.txt"); // 提前准备包含测试数据的文件
    }

    // 清理：测试后重置状态（可选）
    @After
    public void tearDown() {
        lab = null;
    }

    // 测试用例1：有效输入，存在单个桥接词
    @Test
    public void testQueryBridgeWordsValidSingle() {
        String result = lab.queryBridgeWords("a", "c");
        assertEquals("The bridge words from \"a\" to \"c\" are: \"b\".", result);
    }

    // 测试用例2：有效输入，存在多个桥接词（验证字典序）
    @Test
    public void testQueryBridgeWordsValidMultiple() {
        String result = lab.queryBridgeWords("hat", "jake");
        assertEquals("The bridge words from \"hat\" to \"jake\" are: \"i\".", result);
    }

    // 测试用例3：无效输入，word1不存在
    @Test
    public void testQueryBridgeWordsWord1NotExist() {
        String result = lab.queryBridgeWords("x", "d");
        assertEquals("No \"x\" or \"d\" in the graph!", result);
    }

    // 测试用例4：无效输入，word2不存在
    @Test
    public void testQueryBridgeWordsWord2NotExist() {
        String result = lab.queryBridgeWords("a", "y");
        assertEquals("No \"a\" or \"y\" in the graph!", result);
    }

    // 测试用例5：无桥接词
    @Test
    public void testQueryBridgeWordsNoBridge() {
        String result = lab.queryBridgeWords("b", "c");
        assertEquals("No bridge words from \"b\" to \"c\"!", result);
    }

    // 测试用例6：空字符串输入（边界值）
    @Test
    public void testQueryBridgeWordsEmptyInput() {
        String result = lab.queryBridgeWords("", "d");
        assertEquals("No \"\" or \"d\" in the graph!", result);
    }
}