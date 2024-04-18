<?php
include 'koneksi.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $username = mysqli_real_escape_string($koneksi, $_POST['username']);
    $first_name = mysqli_real_escape_string($koneksi, $_POST['first_name']);
    $last_name = mysqli_real_escape_string($koneksi, $_POST['last_name']);
    $email = mysqli_real_escape_string($koneksi, $_POST['email']);
    $password = password_hash($_POST['password'], PASSWORD_DEFAULT); // Use password_hash function

    $query = "INSERT INTO users (username, first_name, last_name, email, password) VALUES (?, ?, ?, ?, ?)";
    $stmt = mysqli_prepare($koneksi, $query);

    if ($stmt) {
        mysqli_stmt_bind_param($stmt, "sssss", $username, $first_name, $last_name, $email, $password);
        $result = mysqli_stmt_execute($stmt);

        if ($result) {
            $response = array('status' => 'success', 'message' => 'Registrasi berhasil');
        } else {
            $response = array('status' => 'error', 'message' => 'Registrasi gagal: ' . mysqli_error($koneksi));
        }

        mysqli_stmt_close($stmt);
    } else {
        $response = array('status' => 'error', 'message' => 'Persiapan query gagal: ' . mysqli_error($koneksi));
    }

    echo json_encode($response);
}
?>