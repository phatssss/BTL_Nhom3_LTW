package com.javaweb.api.admin;

import com.javaweb.model.dto.UserDTO;
import com.javaweb.model.reponse.ResponseDTO;
import com.javaweb.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/admin/customer")
@RequiredArgsConstructor
public class CustomerAPI {

//    @Autowired
    private final UserService userService;

    // Lấy ra danh sách người dùng
    @GetMapping
    public List<UserDTO> getAllCustomer() {
        return userService.getAllUsersWithoutStatus();
    }

    // tìm kiếm người dùng theo điều kiện
    // ví dụ tên, địa chỉ, còn hoạt động hay không
    @GetMapping("/search")
    public List<UserDTO> getCustomerByCondition(@RequestParam(required = false) String key  ,
                                                @RequestParam(defaultValue = "true",required = false) Boolean status) {
        return userService.getUserByCondition(key, status);
    }


    //thêm hoặc sửa người dùng
    @PostMapping
    public ResponseDTO updateUser(@RequestBody UserDTO UserDTO) {
        return userService.updateUser(UserDTO);
    }


    // Xóa mềm người dùng
    @DeleteMapping("/{ids}")
    public ResponseDTO deleteUser(@PathVariable("ids") List<Integer> ids) {
        return userService.deleteUser(ids);
    }



}
