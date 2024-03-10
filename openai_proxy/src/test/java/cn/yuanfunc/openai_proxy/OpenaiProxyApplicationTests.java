package cn.yuanfunc.openai_proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CacheControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetCachedValueSuccess() throws Exception {
		// 假设cacheResponse和getResponse是正常工作的
		// 首先，存储一个值
		mockMvc.perform(post("/cache/myKey")
						.contentType(MediaType.APPLICATION_JSON)
						.content("\"myValue\""))
				.andExpect(status().isOk());

		// 然后，尝试获取这个值
		mockMvc.perform(get("/cache/myKey"))
				.andExpect(status().isOk())
				.andExpect(content().string("\"myValue\""));
	}
}
