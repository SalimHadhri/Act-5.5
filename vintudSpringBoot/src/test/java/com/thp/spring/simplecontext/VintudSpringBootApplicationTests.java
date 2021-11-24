package com.thp.spring.simplecontext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thp.spring.simplecontext.dto.AnnouncementDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = VintudSpringBootApplication.class)
@AutoConfigureMockMvc
@Transactional
public class VintudSpringBootApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void findAllAnnouncementAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/announcementManagement/ListAnnouncement")
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.ListAnnouncement").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.ListAnnouncement[*].idAnnouncement").isNotEmpty());

	}

	@Test
	public void findAnnouncementByIdAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/announcementManagement/findAnnouncement/{id}", 1)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.idAnnouncement").value(1));
	}

	@Test
	public void addAnnouncementAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/announcementManagement/addAnnouncement")
				.content(asJsonString(new AnnouncementDto("soso", "soso", 29, "lololo", "2019", false, 27,
						"testttt", null, null)))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.idAnnouncement").exists());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void updateAnnouncementByIdAPI() throws Exception {		
		
		 mvc.perform( MockMvcRequestBuilders
			      .put("/announcementManagement/updateAnnouncement/{id}", 16)
			      .content(asJsonString(new AnnouncementDto("didi","didi", 16, "didi","2019", false, 16, "didi",null,null)))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("updated"))
			      .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("fddq"))
			      .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(16))
					.andExpect(MockMvcResultMatchers.jsonPath("$.picture").value("updated"))
					.andExpect(MockMvcResultMatchers.jsonPath("$.publication_date").value("2019"))
					.andExpect(MockMvcResultMatchers.jsonPath("$.is_available").value(false))
					.andExpect(MockMvcResultMatchers.jsonPath("$.view_number").value(16))
					 .andExpect(MockMvcResultMatchers.jsonPath("$.localisation").value("updated"))
					 .andExpect(MockMvcResultMatchers.jsonPath("$.userAnnouncement").value(null))
					 .andExpect(MockMvcResultMatchers.jsonPath("$.categoryAnnonce").value(null));

	}
	
	

	@Test
	public void deleteAnnouncementAPI() throws Exception {	
		
		  mvc.perform( MockMvcRequestBuilders.delete("/announcementManagement/deleteAnnouncement/{id}", 14) )
	        .andExpect(status().isAccepted());
	}
	
	

}