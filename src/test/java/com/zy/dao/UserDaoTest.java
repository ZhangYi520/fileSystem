package com.zy.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zy.runProject;

/**  
*   
* 项目名称：bookSystem  
* 类名称：UserDaoTest  
* 类描述：  
* 创建人：zhangyi  
* 创建时间：2019年2月17日 下午3:48:31  
* 修改人：zhangyi  
* 修改时间：2019年2月17日 下午3:48:31  
* 修改备注：  
* @version   
*   
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = runProject.class)
public class UserDaoTest {

	@Autowired
	private UserMapper userMapper;
	@Test
	public void selectUser() {
		System.out.println(userMapper.userList());
	}
}
