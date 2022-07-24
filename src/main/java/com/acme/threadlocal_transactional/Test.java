package com.acme.threadlocal_transactional;

public class Test {
	public static void main(String[] args) throws Exception {

		TransctionProxy transctionProxy = new TransctionProxy();

		// //产生代理对象
		UserManager userManager = (UserManager) transctionProxy
				.newProxyInstance(new UserManagerImpl());
		User user = userManager.findUser("root");
		System.out.println("用户名:" + user.getName());

//		for(int i=0;i<100;i++){
//			new Thread(()->{
//				try{
//					TransctionProxy transctionProxy = new TransctionProxy();
//
//					// //产生代理对象
//					UserManager userManager = (UserManager) transctionProxy
//							.newProxyInstance(new UserManagerImpl());
//					User user = userManager.findUser("root");
//					System.out.println("用户名:" + user.getName());
//				}catch (Exception e){
//					e.printStackTrace();
//				}
//
//			}).start();
//
//		}

	}
}