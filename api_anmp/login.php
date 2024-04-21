<?php
include 'koneksi.php';
session_start(); // Memulai sesi PHP

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['username']) && isset($_POST['password'])) {
        $username = mysqli_real_escape_string($koneksi, $_POST['username']);
        $password = $_POST['password'];
        
        $query = "SELECT * FROM users WHERE username = ?";
        $stmt = mysqli_prepare($koneksi, $query);
        mysqli_stmt_bind_param($stmt, "s", $username);
        mysqli_stmt_execute($stmt);
        $result = mysqli_stmt_get_result($stmt);
        
        if (mysqli_num_rows($result) > 0) {
            $row = mysqli_fetch_assoc($result);
            $hashedPassword = $row['password'];
            
            if (password_verify($password, $hashedPassword)) {
                $userId = $row['id']; 
                $response = array('status' => 'success', 'message' => 'Login berhasil', 'userId' => $userId);
            } else {
                $response = array('status' => 'error', 'message' => 'Username atau password salah');
            }
        } else {
            $response = array('status' => 'error', 'message' => 'Username atau password salah');
        }
        
        mysqli_stmt_close($stmt);
    } else {
        $response = array('status' => 'error', 'message' => 'Parameter username atau password tidak ada');
    }
} else {
    $response = array('status' => 'error', 'message' => 'Metode permintaan tidak valid');
}

echo json_encode($response);
?>