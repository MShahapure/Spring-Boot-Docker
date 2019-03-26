//package com.hello;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.hello.controller.NoteController;
//import com.hello.repository.NoteRepository;
//import com.hello.service.Service;
//import com.hello.service.impl.NoteServiceImpl;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class EasyNotesApplicationTests {
//
//	private MockMvc mockMvc;
//	
//	@MockBean
//	Service service;
//	@InjectMocks
//	NoteServiceImpl serviceImpl;
//	
//	@Mock
//	NoteRepository noteReopsitory;
//	
//	@InjectMocks
//	NoteController noteContoller;
//	
//	@Autowired
//	private WebApplicationContext wac;
//
//	private final String apiPrefix = "/api";
//	
//	@Before
//	public void setup() {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//	}
//	
//	private String createNotesInJson(String title, String content) {
//	 return "{ \"title\": \"" + title + "\", " + "\"content\":\"" + content +  "\"}";
//	}
//	
//	@Test
//	public void verifyCreateNote() throws Exception {
//		 mockMvc.perform(post(apiPrefix+"/createNote")
//	                .contentType(MediaType.APPLICATION_JSON)
//	                .content(createNotesInJson("My Fifth Note",
//                            "Suyash is AWESOME")))
//	                .andExpect(status().isOk()).andDo(print());	 
//	}
//	
//	@Test
//	public void verifyGetNoteById() throws Exception {		
//		 mockMvc.perform(get(apiPrefix+"/getById/2"))
//	                .andExpect(status().isOk()).andDo(print());		
//	}
//	
//	
//
//	private String updateNotesInJson(String title, String content) {
//	 return "{ \"title\": \"" + title + "\", " + "\"content\":\"" + content +  "\"}";
//	}
//	
//	@Test
//	public void verifyUpdateNote() throws Exception {
//		 mockMvc.perform(put(apiPrefix+"/updateNote/6")
//	                .contentType(MediaType.APPLICATION_JSON)
//	                .content(updateNotesInJson("My Fifth Note",
//                            "Suyash is Good")))
//	                .andExpect(status().isOk()).andDo(print());	 
//	}
//	
//	private String updateTitleInJson(String id,String title) {
//		 return "{ \"id\": \"" + id + "\",\"title\": \"" + title + "\"}";
//	}
//	
//	@Test
//	public void verifyUpdateTitle() throws Exception {
//		 mockMvc.perform(post(apiPrefix+"/updateTitle")
//	                .contentType(MediaType.APPLICATION_JSON)
//	                .content(updateTitleInJson("4","My Fourth Note")))
//	                .andExpect(status().isOk()).andDo(print());	 
//	}
//
//	@Test
//	public void verifyDeleteNote() throws Exception {
//		 mockMvc.perform(delete(apiPrefix+"/deleteNote/6"))
//	                .andExpect(status().isOk()).andDo(print());	 
//	}
//}
