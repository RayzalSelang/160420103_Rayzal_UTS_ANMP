<?php
// update_profile.php

// Koneksi ke database
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "uts_anmp";

$conn = new mysqli($servername, $username, $password, $dbname);

// Cek koneksi
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$user_id = $_POST['user_id'];
$first_name = $_POST['first_name'];
$last_name = $_POST['last_name'];
$password = $_POST['password'];

$sql = "UPDATE users SET first_name = '$first_name', last_name = '$last_name', password = '$password' WHERE id = $user_id";

if ($conn->query($sql) === TRUE) {
    $response = array('status' => 'success', 'message' => 'Profile updated successfully');
} else {
    $response = array('status' => 'error', 'message' => 'Failed to update profile');
}

$conn->close();

header('Content-Type: application/json');
echo json_encode($response);
?>