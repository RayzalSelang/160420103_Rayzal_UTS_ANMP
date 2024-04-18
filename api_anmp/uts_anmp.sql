-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 18 Apr 2024 pada 07.44
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uts_anmp`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id`, `username`, `first_name`, `last_name`, `email`, `password`) VALUES
(1, 'aa', 'aa', 'aa', 'aa', '$2y$10$qs7onmbYYJRl.h0DQrAYMu9pacH0ayk9dNUYHFFhA.e3QLRYKbB1y'),
(8, 'b', 'b', 'b', 'b', '$2y$10$0ZN1FZtbEl9xWqEvF9etEOvsma1joKObB.p/741kW.0uwKhbcQEIi'),
(9, 'c', 'c', 'c', '2', '$2y$10$fsE1vwwjqxjeU83IfygcvexnSzALGYP.TZUlHI1lVg0SxZfJ9/ng2'),
(10, 'rayzal', 'rayzal', 'selang', 'rayzalselang14@gmail.com', '$2y$10$kR3.u1cBQIrZTA8eTww1KehcAo4mdxNO78tJKXnTvaA0aLwHdXZX6'),
(11, 'd', 'd', 'd', 'd', '$2y$10$CghOqjQAbxB5t5M22v.Mx.0cejk3R6mJLodiytZEAKX7fvf4JQH0y'),
(12, '', '', '', '', '$2y$10$sdeRvyLQXbiFY4iaXPQL7uz8rk5AkHYTQgtLtSFc.5CjjYl3ZeKCG'),
(13, 'rey', 'r', 's', 's', '$2y$10$VX188N.U4j/THZSJJQRIj.BcWHJPOJwboU604wRkAXBkcBcRgYdsK'),
(14, 'fajar', 'fajar', 'fajar', 'fajar', '$2y$10$ijDdc9LpLaGB9md8sP1BmedvPdwvSmGi3fSrO8SW1I3D1w3EifjGy'),
(15, 'f', 'f', 'f', 'f', '$2y$10$lE7w8jZxRSX.8GBxnK4Fq.Rfe6G434xmiSMv9sUt/84.YGzCEBR1i'),
(16, 'z', 'x', 'x', 'z', 'x'),
(17, 'p', 'p', 'p', 'p', '$2y$10$9pYTpKUtYNzAYw4PNbl/Eub8S8ViFsUYOFOWflJgD.Wpha50MBkOW'),
(18, 'Ra', 'ra', 'se', 'ra', '$2y$10$.pC2E9SeYrulvddVl9cSPew/8dYNC0Vgw6LUho4GiTelnMwZxWPtm'),
(19, 'y', 'y', 'y', 'y', '$2y$10$EOvdsaoLHNSFvNCVA9iOEec9w9tkd4NMb2GHupDOO7mAoWeU1ms9C');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
