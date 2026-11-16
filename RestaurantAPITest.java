package com.hunger.saviour.portal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.hunger.saviour.portal.dtos.RestaurantDTO;
import com.hunger.saviour.portal.dtos.RestaurantMenuDTO;
import com.hunger.saviour.portal.service.RestaurantService;

@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantAPITest {

	@MockitoBean
	private RestaurantService restaurantService;

	@Autowired
	private MockMvc mockMvc;

//	@Test
	public void testCreateRestaurant() {

		RestaurantDTO restaurantDTO = new RestaurantDTO();

		restaurantDTO.setRestaurantName("r1");
		restaurantDTO.setImageUrl("njds");
		restaurantDTO.setRestaurantId(11);
		restaurantDTO.setRating("2");
		restaurantDTO.setMenuTypes(List.of("d1", "d2"));
		restaurantDTO.setLocation("ii");

		RestaurantMenuDTO restaurantMenuDTO = new RestaurantMenuDTO();
		restaurantMenuDTO.setDescription("des");
		restaurantMenuDTO.setMenuItem("menuit");
		restaurantMenuDTO.setMenuItemImageUrl("menu-img");
		restaurantMenuDTO.setMenuType("menu-typ");
		restaurantMenuDTO.setPrice(334.44);
		restaurantMenuDTO.setRestaurantMenuId(11);
		restaurantDTO.setMenus(List.of(restaurantMenuDTO));
		
		
//		Mockito.when(restaurantService.createRestaurant(Mockito.any(RestaurantDTO.class))).thenReturn(ResponseDTO);
		
//		mockmvc.perform(post("/restaurants")).contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(requestDTO))
//		.andExpect(status().isCreated());
		
	}
	
	@Test
	public void testGetRestaurantById() {
		
		RestaurantDTO restaurantDTO = new RestaurantDTO();

		restaurantDTO.setRestaurantName("r1");
		restaurantDTO.setImageUrl("njds");
		restaurantDTO.setRestaurantId(11);
		restaurantDTO.setRating("2");
		restaurantDTO.setMenuTypes(List.of("d1", "d2"));
		restaurantDTO.setLocation("ii");
		

		RestaurantMenuDTO restaurantMenuDTO = new RestaurantMenuDTO();
		restaurantMenuDTO.setDescription("des");
		restaurantMenuDTO.setMenuItem("menuit");
		restaurantMenuDTO.setMenuItemImageUrl("menu-img");
		restaurantMenuDTO.setMenuType("menu-typ");
		restaurantMenuDTO.setPrice(334.44);
		restaurantMenuDTO.setRestaurantMenuId(11);
		restaurantDTO.setMenus(List.of(restaurantMenuDTO));
		
		Mockito.when(restaurantService.getRestaurantById(Mockito.anyInt()))
		.thenReturn(restaurantDTO);
		
		try {
			mockMvc.perform(get("restaurants/11")).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void getAllRestaurants() {
		
		RestaurantDTO restaurantDTO = new RestaurantDTO();

		restaurantDTO.setRestaurantName("r1");
		restaurantDTO.setImageUrl("njds");
		restaurantDTO.setRestaurantId(11);
		restaurantDTO.setRating("2");
		restaurantDTO.setMenuTypes(List.of("d1", "d2"));
		restaurantDTO.setLocation("ii");
		

		RestaurantMenuDTO restaurantMenuDTO = new RestaurantMenuDTO();
		restaurantMenuDTO.setDescription("des");
		restaurantMenuDTO.setMenuItem("menuit");
		restaurantMenuDTO.setMenuItemImageUrl("menu-img");
		restaurantMenuDTO.setMenuType("menu-typ");
		restaurantMenuDTO.setPrice(334.44);
		restaurantMenuDTO.setRestaurantMenuId(11);
		restaurantDTO.setMenus(List.of(restaurantMenuDTO));
		
		RestaurantDTO restaurantDTO1 = new RestaurantDTO();

		restaurantDTO1.setRestaurantName("r1");
		restaurantDTO1.setImageUrl("njds");
		restaurantDTO1.setRestaurantId(11);
		restaurantDTO1.setRating("2");
		restaurantDTO1.setMenuTypes(List.of("d1", "d2"));
		restaurantDTO1.setLocation("ii");
		

		RestaurantMenuDTO restaurantMenuDTO1 = new RestaurantMenuDTO();
		restaurantMenuDTO1.setDescription("des");
		restaurantMenuDTO1.setMenuItem("menuit");
		restaurantMenuDTO1.setMenuItemImageUrl("menu-img");
		restaurantMenuDTO1.setMenuType("menu-typ");
		restaurantMenuDTO1.setPrice(334.44);
		restaurantMenuDTO1.setRestaurantMenuId(11);
		restaurantDTO1.setMenus(List.of(restaurantMenuDTO));
		
		List<RestaurantDTO> listRest = List.of(restaurantDTO,restaurantDTO1);
		
		Mockito.when(restaurantService.getAllRestaurants()).thenReturn(listRest);
		
	 try {
		mockMvc.perform(get("restaurants")).andExpect(status().isOk());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
