package com.yichin.powermokito;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

// Mockito - Verifying Mock Behavior in Java Unit Tests-> https://www.youtube.com/watch?v=Qq0uziWeMAA
// Mockito - Stubbing Behavior in Java Unit Tests -> https://www.youtube.com/watch?v=DyuWgBHfxNQ  
@SuppressWarnings("deprecation")
public class UserServiceTest {

	@Test
	public void testSave() throws Exception {
		
		UserManager manager = Mockito.mock(UserManager.class); 
		UserService service = new UserService(manager);
		service.save("123");
		
		// Verifies certain behavior happened once. 
		Mockito.verify(manager).save("123");
		// Verifies certain behavior happened exact number of times 
		Mockito.verify(manager, Mockito.times(1)).save("123");
		// This will fail
		// Mockito.verify(manager, Mockito.times(1)).save("456");
		// This will fail
		// Mockito.verify(manager, Mockito.times(2)).save("123");
		
		
		// Verifies this function never be called
		Mockito.verify(manager, Mockito.times(0)).getUserCount();
	}

	@Test
	public void testSave2() {
		
		UserManager manager = Mockito.mock(UserManager.class);
		ArgumentCaptor<String> arg;
		arg = ArgumentCaptor.forClass(String.class);
		
		UserService service = new UserService(manager);
		service.save("123");
			
		// arg.capture(): catch value
		Mockito.verify(manager).save(arg.capture());
		Assert.assertEquals("123", arg.getValue());
	}
	
	@Test
	public void test3() throws Exception{
		UserManager manager = Mockito.mock(UserManager.class);
		UserService service = new UserService(manager);
		Mockito.when(manager.getUserCount()).thenReturn(50);
		Assert.assertEquals(50, service.getUserCount());
	}
	
	@Test
	public void test4() throws Exception{
		UserManager manager = Mockito.mock(UserManager.class);
		UserService service = new UserService(manager);
		Mockito.when(manager.getUserCount()).thenThrow(new RuntimeException());
		Assert.assertEquals(-1, service.getUserCount());
	}
}
