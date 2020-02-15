# demo-t3h

git config --global user.name = ""
git config --global user.email = "" 



git status -- kiem tra nhung file nao thay doi



buoc 1 : Tao 1 nhanh moi tu nhanh develop
neu chua co develop 
git checkout -b develop

git push -f origin develop

git branch -a : liet ke cac kho tren may local cua minh

chuyen nhanh thi dung : git checkout abcdashuda , git checkout develop

tao 1 nhanh moi git: checkout -b ngo.trieu/update_fhaushua


b1 :git checkout develop
b1.1 : git pull origin develop
b2 :git checkout git checkout -b ngo.trieu/update_fhaushua
b3 : sau khi them file , sua file
git status : xem thay doi file nao
b4 : git add sr.chsduashui/asdhuasdi.java
b5 : git commit -m "noi dung update"
b6 : git push -f origin ngo.trieu/update_fhaushua

Phan 2 : merge code moi thay doi vao develop
b1 : git checkout develop
b2 : git pull
b3 : git merge origin/ngo.trieu/update_fhaushua
b4 : git push origin develop

