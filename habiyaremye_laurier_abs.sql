-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 12:04 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `habiyaremye_laurier_abs`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AdminID` int(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Phonenumber` varchar(50) NOT NULL,
  `Email` text NOT NULL,
  `Role` text NOT NULL,
  `Password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminID`, `Name`, `Phonenumber`, `Email`, `Role`, `Password`) VALUES
(1, 'Laurier HABIYAREMYE', '0780115764', 'laurier@admin.abs.com', 'General Admin', 'laurier123'),
(2, 'Moise HAGENAYEZU', '+250 789 999 000', 'moise@gmail.com', 'Analyst', 'moise123'),
(3, 'Bellyse Arlande', '+250 788  999 999', 'bellyse@gmail.com', 'Dispatcher', 'bellyse123'),
(4, '', '', '', 'General Admin', ''),
(5, 'Eliane mmm', '07888888', 'eliane@gmail.com', 'Dispatcher', 'eliane123');

-- --------------------------------------------------------

--
-- Table structure for table `ambulance`
--

CREATE TABLE `ambulance` (
  `AmbulanceID` int(11) NOT NULL,
  `VehicleNumber` varchar(20) DEFAULT NULL,
  `Type` varchar(50) DEFAULT NULL,
  `Capacity` int(11) DEFAULT NULL,
  `Equipment` text DEFAULT NULL,
  `CurrentLocation` text DEFAULT NULL,
  `DriverName` varchar(255) DEFAULT NULL,
  `DriverContact` varchar(20) DEFAULT NULL,
  `DriverCertification` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ambulance`
--

INSERT INTO `ambulance` (`AmbulanceID`, `VehicleNumber`, `Type`, `Capacity`, `Equipment`, `CurrentLocation`, `DriverName`, `DriverContact`, `DriverCertification`) VALUES
(1, 'RAD-001C', 'Basic', 2, 'First Aid Kit, Oxygen', '-1.949180', 'Sean MUGABE', '+250731234567', 'Certified EMT'),
(2, 'RAG-002D', 'Advanced', 4, 'Defibrillator, Ventilator', '-1.949560', 'Aline KEZA', '+250789876543', 'Paramedic Certified'),
(3, 'RAG-002G', 'Basic +', 3, 'Byose', 'Muhanga', 'Vuba', '0987654321', 'Basic Life Support (BLS)');

-- --------------------------------------------------------

--
-- Table structure for table `bookingrequest`
--

CREATE TABLE `bookingrequest` (
  `BookingID` int(11) NOT NULL,
  `UserID` int(11) DEFAULT NULL,
  `PickupLocation` varchar(50) DEFAULT NULL,
  `Destination` varchar(50) DEFAULT NULL,
  `HospitalName` varchar(50) DEFAULT NULL,
  `RequestedTime` datetime DEFAULT NULL,
  `PriorityLevel` varchar(20) DEFAULT NULL,
  `Reason` text DEFAULT NULL,
  `AdditionalNotes` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bookingrequest`
--

INSERT INTO `bookingrequest` (`BookingID`, `UserID`, `PickupLocation`, `Destination`, `HospitalName`, `RequestedTime`, `PriorityLevel`, `Reason`, `AdditionalNotes`) VALUES
(1, 1, '30.059917', '30.061589', 'CHUK', '2023-09-12 08:00:00', 'High', 'Emergency', 'Patient is in critical condition'),
(2, 2, '30.058123', '30.055432', 'Laurier Int Hospital', '2023-09-12 10:30:00', 'Medium', 'Accident', 'Multiple injuries reported'),
(3, 3, '30.058123', '30.055432', 'Laurier Int Hospital', '2023-09-12 10:35:10', 'High', 'Accident', 'Patient had a panic'),
(4, 2, 'Huye', 'Huye', 'CHUB', '2024-02-03 13:57:41', 'CHUB', 'CHUB', 'ii'),
(5, 2, 'Kigali', 'Rubavu', 'Laurier Int Hospital', '2024-02-03 14:03:29', 'Laurier Int Hospital', 'Laurier Int Hospital', 'giye'),
(6, 3, 'Rubavu', 'Muhanga', 'KABGAYI Hospital', '2024-02-03 14:05:18', 'KABGAYI Hospital', 'KABGAYI Hospital', 'ijj'),
(7, 2, 'Huye', 'Rubavu', 'Laurier Int Hospital', '2024-02-04 10:34:12', 'Laurier Int Hospital', 'Laurier Int Hospital', 'dont worry its me'),
(8, 3, 'Huye', 'Rubavu', 'Laurier Int Hospital', '2024-02-04 10:34:12', 'Laurier Int Hospital', 'Laurier Int Hospital', 'dont worry its me');

--
-- Triggers `bookingrequest`
--
DELIMITER $$
CREATE TRIGGER `BookingRequestAfterDelete` AFTER DELETE ON `bookingrequest` FOR EACH ROW BEGIN

    UPDATE Trip
    SET Status = 'Canceled'
    WHERE BookingID = OLD.BookingID;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bookingrequestAfterInsert` AFTER INSERT ON `bookingrequest` FOR EACH ROW BEGIN
  INSERT INTO Notification (UserID, Content, Timestamp, Status)
   VALUES (NEW.UserID, 'A new booking request has been made.', NOW(), 'New Request');
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `emergencycontacts`
--

CREATE TABLE `emergencycontacts` (
  `ContactID` int(11) NOT NULL,
  `UserID` int(11) DEFAULT NULL,
  `ContactName` varchar(255) DEFAULT NULL,
  `Relationship` varchar(50) DEFAULT NULL,
  `ContactPhoneNumber` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `emergencycontacts`
--

INSERT INTO `emergencycontacts` (`ContactID`, `UserID`, `ContactName`, `Relationship`, `ContactPhoneNumber`) VALUES
(1, 1, 'Aline MUGISHA', 'Wife', '+250732345678'),
(2, 2, 'Joh KAREMERA', 'Sibling', '+250784576456');

-- --------------------------------------------------------

--
-- Table structure for table `feedbackandratings`
--

CREATE TABLE `feedbackandratings` (
  `FeedbackID` int(10) NOT NULL,
  `TripID` int(10) NOT NULL,
  `UserID` int(10) NOT NULL,
  `Rating_Stars` varchar(50) NOT NULL,
  `Comments` text NOT NULL,
  `FeedbackDateTime` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `feedbackandratings`
--

INSERT INTO `feedbackandratings` (`FeedbackID`, `TripID`, `UserID`, `Rating_Stars`, `Comments`, `FeedbackDateTime`) VALUES
(1, 1, 1, '[Ljava.lang.Object;@76b48bf0', 'uhuhu', '2024-02-03'),
(2, 2, 2, '[Ljava.lang.Object;@5b88dba6', 'NONONO', '2024-02-06');

-- --------------------------------------------------------

--
-- Table structure for table `insert_emergencycontactsview`
--

CREATE TABLE `insert_emergencycontactsview` (
  `ContactID` int(11) DEFAULT NULL,
  `UserID` int(11) DEFAULT NULL,
  `ContactName` varchar(255) DEFAULT NULL,
  `Relationship` varchar(50) DEFAULT NULL,
  `ContactPhoneNumber` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `insert_paymentview`
--

CREATE TABLE `insert_paymentview` (
  `PaymentID` int(11) DEFAULT NULL,
  `TripID` int(11) DEFAULT NULL,
  `UserID` int(11) DEFAULT NULL,
  `PaymentMethod` varchar(20) DEFAULT NULL,
  `Amount` text DEFAULT NULL,
  `PaymentDateTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `NotificationID` int(11) NOT NULL,
  `UserID` int(11) DEFAULT NULL,
  `Content` text DEFAULT NULL,
  `Timestamp` datetime DEFAULT NULL,
  `Status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`NotificationID`, `UserID`, `Content`, `Timestamp`, `Status`) VALUES
(1, 6, 'A new user has been added.', '2023-09-16 16:44:49', 'New User'),
(3, 7, 'A new user has been added.', '2024-02-02 15:40:14', 'New User'),
(4, 2, 'User information updated: Jane KEZA', '2024-02-02 15:41:40', 'User Updated'),
(5, 8, 'A new user has been added.', '2024-02-02 15:54:57', 'New User'),
(6, 9, 'A new user has been added.', '2024-02-02 16:03:24', 'New User'),
(7, 7, 'User information updated: Lolie HABIYAREMYE', '2024-02-03 15:44:36', 'User Updated'),
(8, 3, 'User information updated: Sam ISHIMWE', '2024-02-03 16:19:05', 'User Updated'),
(9, 1, 'User information updated: John MUGISHA', '2024-02-03 16:40:17', 'User Updated'),
(10, 2, 'A new booking request has been made.', '2024-02-04 10:35:00', 'New Request'),
(11, 3, 'A new booking request has been made.', '2024-02-04 10:35:11', 'New Request'),
(12, 3, 'A new payment is loaded.', '2024-02-04 10:36:30', 'New Payment'),
(13, 2, 'A new payment is loaded.', '2024-02-04 10:36:41', 'New Payment'),
(14, 2, 'User information updated: Jane KEZA', '2024-02-04 14:35:28', 'User Updated'),
(15, 2, 'User information updated: Jane KEZA', '2024-02-04 15:08:13', 'User Updated'),
(16, 2, 'User information updated: Jane KEZA', '2024-02-04 15:08:40', 'User Updated'),
(17, 2, 'User information updated: Jane KEZA', '2024-02-04 15:09:07', 'User Updated'),
(18, 2, 'User information updated: Jane KEZA', '2024-02-04 15:17:03', 'User Updated'),
(19, 5, 'User information updated: John RUREMA', '2024-02-04 15:26:37', 'User Updated'),
(20, 5, 'User information updated: John RUREMA', '2024-02-04 15:26:51', 'User Updated'),
(21, 5, 'User information updated: John RUREMA', '2024-02-04 15:33:09', 'User Updated'),
(22, 5, 'User information updated: John RUREMA', '2024-02-04 15:33:26', 'User Updated'),
(23, 5, 'User information updated: John RUREMA', '2024-02-04 15:48:58', 'User Updated'),
(24, 5, 'User information updated: GREENS AB', '2024-02-04 15:49:13', 'User Updated'),
(25, 5, 'User information updated: John RUREMA', '2024-02-04 15:49:45', 'User Updated'),
(26, 5, 'User information updated: John RUREMA', '2024-02-04 15:50:01', 'User Updated'),
(27, 2, 'User information updated: Jane KEZA', '2024-02-04 15:56:38', 'User Updated'),
(28, 2, 'User information updated: Jane KEZA', '2024-02-04 15:58:16', 'User Updated'),
(29, 2, 'User information updated: Jane KEZA', '2024-02-04 21:05:43', 'User Updated'),
(30, 2, 'User information updated: Jane KEZA', '2024-02-04 21:06:00', 'User Updated'),
(31, 6, 'User information updated: Alain MIKWEGE', '2024-02-05 16:01:09', 'User Updated'),
(32, 6, 'User information updated: Alain MIKWEGE', '2024-02-05 16:01:26', 'User Updated'),
(33, 2, 'A new payment is loaded.', '2024-02-06 21:21:45', 'New Payment'),
(34, 2, 'A new payment is loaded.', '2024-02-06 21:21:49', 'New Payment'),
(35, 1, 'User information updated: John MUGISHA', '2024-02-15 12:44:22', 'User Updated'),
(36, 1, 'User information updated: John MUGISHA', '2024-02-15 12:45:32', 'User Updated'),
(37, 5, 'User information updated: John RUREMA', '2024-02-15 12:45:32', 'User Updated');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `PaymentID` int(11) NOT NULL,
  `TripID` int(11) DEFAULT NULL,
  `UserID` int(11) DEFAULT NULL,
  `PaymentMethod` varchar(20) DEFAULT NULL,
  `Amount` text DEFAULT NULL,
  `PaymentDateTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`PaymentID`, `TripID`, `UserID`, `PaymentMethod`, `Amount`, `PaymentDateTime`) VALUES
(1, 1, 1, 'Credit Card', '75.00', '2023-09-12 11:00:00'),
(2, 2, 2, 'Bitcoin', '65.00', '2023-09-12 12:15:00'),
(3, 3, 3, 'Bitcoin', '70.50', '2023-09-12 12:15:00'),
(4, 1, 1, 'PayPal', '50.00', '2024-02-03 14:29:40'),
(5, 1, 1, 'Credit Card', '50$', '2024-02-03 14:30:58'),
(6, 3, 3, 'PayPal', '69$', '2024-02-04 10:36:11'),
(7, 2, 2, 'PayPal', '69$', '2024-02-04 10:36:11'),
(8, 2, 2, 'Bitcoin', '76$', '2024-02-06 21:21:26'),
(9, 2, 2, 'Bitcoin', '76$', '2024-02-06 21:21:26');

--
-- Triggers `payment`
--
DELIMITER $$
CREATE TRIGGER `paymentAfterInsert` AFTER INSERT ON `payment` FOR EACH ROW BEGIN
  INSERT INTO Notification (UserID, Content, Timestamp, Status)
   VALUES (NEW.UserID, 'A new payment is loaded.', NOW(), 'New Payment');
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `reportsandanalytics`
--

CREATE TABLE `reportsandanalytics` (
  `ReportID` int(11) NOT NULL,
  `ReportType` varchar(50) DEFAULT NULL,
  `DateRange` varchar(50) DEFAULT NULL,
  `GeneratedBy` int(11) DEFAULT NULL,
  `ReportContent` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `trip`
--

CREATE TABLE `trip` (
  `TripID` int(11) NOT NULL,
  `BookingID` int(11) DEFAULT NULL,
  `AmbulanceID` int(11) DEFAULT NULL,
  `PickupTime` datetime DEFAULT NULL,
  `DropoffTime` datetime DEFAULT NULL,
  `DistanceTraveled` text DEFAULT NULL,
  `Fare` text DEFAULT NULL,
  `PaymentStatus` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `trip`
--

INSERT INTO `trip` (`TripID`, `BookingID`, `AmbulanceID`, `PickupTime`, `DropoffTime`, `DistanceTraveled`, `Fare`, `PaymentStatus`) VALUES
(1, 1, 1, '2023-09-12 10:35:00', '2023-09-12 10:55:00', '5.30', '75.00', 'Paid'),
(2, 2, 2, '2023-09-12 11:50:00', '2023-09-12 12:10:00', '4.80', '65.00', 'Pending'),
(3, 3, 2, '2023-09-12 10:52:10', '2023-09-12 11:37:19', '5.80', '70.50', 'Paid'),
(4, 3, NULL, '2024-02-03 15:37:41', '2024-02-03 17:37:41', '96KM', '45$', 'Rebuilt');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UserID` int(11) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `PhoneNumber` varchar(20) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `DateOfBirth` text DEFAULT NULL,
  `Gender` text DEFAULT NULL,
  `Password` text NOT NULL,
  `Insurance` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserID`, `Name`, `PhoneNumber`, `Email`, `Address`, `DateOfBirth`, `Gender`, `Password`, `Insurance`) VALUES
(1, 'John MUGISHA', '+250780116574', 'johnm@gmail.com', 'Kigali, Rwanda', '1990-01-15', 'Male', 'john123', ''),
(2, 'Jane KEZA', '+250787654321', 'jane@gmail.com', 'Kicukiro', '1985-03-20', 'Female', 'jane123', 'Greens Ic'),
(3, 'Sam ISHIMWE', '+250723456745', 'sam@gmail.com', 'Kigali, Rwanda', '1990-01-15', 'Male', 'sam123', ''),
(5, 'John RUREMA', '+250732345678', 'johnm@gmail.com', 'Kigali, Rwanda', '1990-01-15', 'Male', 'john123', 'GREEENS AB'),
(6, 'Alain MIKWEGE', '+250723456700', 'alainmikwege@gmail.com', 'Kigali, Rwanda', '1990-11-25', 'Male', 'alain123', 'RSSB'),
(7, 'Lolie HABIYAREMYE', '+250789009876', 'laurier@adm.abs.com', 'Huye', '30-11-2000', 'Male', 'laurier123', 'Greens AB'),
(8, 'Kashmil RUGIRA', '+25078765432', 'kashmil@gmail.com', 'Burera', '20-02-2003', 'Prefer not to say', 'kashmil123', 'RADIANT'),
(9, 'Kashmil RUGIRA', '+25078765432', 'kashmil@gmail.com', 'Burera', '02-02-2000', 'Prefer not to say', 'kashmil123', 'RADIANT');

--
-- Triggers `user`
--
DELIMITER $$
CREATE TRIGGER `UserAfterDelete` AFTER DELETE ON `user` FOR EACH ROW BEGIN
    INSERT INTO Notification (UserID, Content, Timestamp, Status)
    VALUES (OLD.UserID, CONCAT('User deleted: ', OLD.Name), NOW(), 'User Deleted');
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `UserAfterInsert` AFTER INSERT ON `user` FOR EACH ROW BEGIN
  INSERT INTO Notification (UserID, Content, Timestamp, Status)
   VALUES (NEW.UserID, 'A new user has been added.', NOW(), 'New User');
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `UserAfterUpdate` AFTER UPDATE ON `user` FOR EACH ROW BEGIN

    INSERT INTO Notification (UserID, Content, Timestamp, Status)
    VALUES (NEW.UserID, CONCAT('User information updated: ', NEW.Name), NOW(), 'User Updated');
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `userview`
--

CREATE TABLE `userview` (
  `UserID` int(11) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `PhoneNumber` varchar(20) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
