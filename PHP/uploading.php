<!-- // 
 
//     $target_path1 = "C://xampp1//htdocs//upload//";
//     /* Add the original filename to our target path. Result is "uploads/filename.extension" */
//     $target_path1 = $target_path1 . basename($_FILES['uploaded_file']['name']);
//     if (move_uploaded_file($_FILES['uploaded_file']['tmp_name'], $target_path1)) {
//         echo "The first file " . basename($_FILES['uploaded_file']['name']) . " has been uploaded.";
//     } else {
//         echo "There was an error uploading the file, please try again!";
//         echo "filename: " . basename($_FILES['uploaded_file']['name']);
//         echo "target_path: " . $target_path1;
//     }
 
//  -->



<?php
error_reporting(E_ALL);
if(isset($_POST['ImageName'])){

$imgname = $_POST['ImageName'];
$imsrc = base64_decode($_POST['base64']);
$fp = fopen($imgname, 'w');
fwrite($fp, $imsrc);
 $t="C://xampp1//htdocs//upload//";
move_uploaded_file($fp,$t);
//if(fclose($fp)){
 //echo "Image uploaded";
//}else{
 //echo "Error uploading image";
}

?>