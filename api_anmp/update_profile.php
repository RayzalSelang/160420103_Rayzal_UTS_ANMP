<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "uts_anmp";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$user_id = $_POST['user_id'];
$first_name = $_POST['first_name'];
$last_name = $_POST['last_name'];
$password = password_hash($_POST['password'], PASSWORD_DEFAULT);

$stmt = $conn->prepare("UPDATE users SET first_name = ?, last_name = ?, password = ? WHERE id = ?");
$stmt->bind_param("sssi", $first_name, $last_name, $password, $user_id);

if ($stmt->execute()) {
    $response = array('status' => 'success', 'message' => 'Profile updated successfully');
} else {
    $response = array('status' => 'error', 'message' => 'Failed to update profile');
}

$stmt->close();
$conn->close();

header('Content-Type: application/json');
echo json_encode($response);
?>