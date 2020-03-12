# Project Demo-T3H


*  Hướng dẫn để tạo 1 merge request 

1. `git status` kiểm tra những file nào thay đổi trên local của mình .
2. `git checkout develop` checkout vào nhánh develop để lấy code mới nhất .
3. `git checkout -b task/#` tạo 1 branch mới có tên là `task/#` từ develop . 
4. `git status` sau khi created code xong thì dùng câu lệnh `git status` để xem những file mình đã thay đổi.
5. `git add file_name` thêm những file do chính mình thay đổi . nếu tự tin hơn có thể dùng lệnh `git add .`.
6. `git commit -m "update code to develop"` commit những file mình thay đổi kèm comment mô tả ngắn.
7. `git push -f origin task/#` đẩy branch mình vừa làm về develop và chờ merge code.

*  Các lệnh `git` hay dùng

1.  `git reset --HARD` reset hết những file mình thay đổi về branch gốc .
2.  `git clean -d -f` remove những file mình thêm .
3.  `git fetch` pull hết những branch về máy của mình.

*  Hướng dẫn merge code vào develop

1.  `git checkout develop` checkout vào branch develop .
2.  `git pull`  pull code về máy
3.  `git merge origin/task/#` merge code mới vào nhánh develop
4.  `git push origin develop` đẩy code đã merge lên.
>  Cách merge này ít dùng vì có thể gây mất code của người khác .



**trieu.ngoquang**
