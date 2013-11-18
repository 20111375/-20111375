package gui;

import camp.Booking;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrew on 07/11/13.
 */
public class ReportBookingSummary {
    private JTextPane Surname;
    private JTextPane County;
    private JTextPane PostCode;
    private JTextPane CarReg;
    private JTextPane CustomerID;
    private JTextPane PitchID;
    private JTextPane StartDate;
    private JTextPane EndDate;

    public JTextPane getBookingSummary() {
        return BookingSummary;
    }

    public void setBookingSummary(JTextPane bookingSummary) {
        BookingSummary = bookingSummary;
    }

    public JTextPane getSurname() {
        return Surname;
    }

    public void setSurname(JTextPane surname) {
        Surname = surname;
    }

    public JTextPane getCounty() {
        return County;
    }

    public void setCounty(JTextPane county) {
        County = county;
    }

    public JTextPane getPostCode() {
        return PostCode;
    }

    public void setPostCode(JTextPane postCode) {
        PostCode = postCode;
    }

    public JTextPane getCarReg() {
        return CarReg;
    }

    public void setCarReg(JTextPane carReg) {
        CarReg = carReg;
    }

    public JTextPane getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(JTextPane customerID) {
        CustomerID = customerID;
    }

    public JTextPane getPitchID() {
        return PitchID;
    }

    public void setPitchID(JTextPane pitchID) {
        PitchID = pitchID;
    }

    public JTextPane getStartDate() {
        return StartDate;
    }

    public void setStartDate(JTextPane startDate) {
        StartDate = startDate;
    }

    public JTextPane getEndDate() {
        return EndDate;
    }

    public void setEndDate(JTextPane endDate) {
        EndDate = endDate;
    }

    public JTextPane getPaid() {
        return Paid;
    }

    public void setPaid(JTextPane paid) {
        Paid = paid;
    }

    public JTextPane getCost() {
        return Cost;
    }

    public void setCost(JTextPane cost) {
        Cost = cost;
    }

    public JTextPane getAddress() {
        return Address;
    }

    public void setAddress(JTextPane address) {
        Address = address;
    }

    public JTextPane getForename() {
        return Forename;
    }

    public void setForename(JTextPane forename) {
        Forename = forename;
    }

    private JTextPane Paid;
    private JTextPane Cost;
    private JTextPane Address;
    private JTextPane Forename;
    private JTextPane BookingSummary;
    private JButton ConfirmBooking;
    private JButton emailButton;
    private JButton printButton;
    private JPanel Summary;
    private JCheckBox paidCheckBox;

    public ReportBookingSummary(Booking confirmBooked) {
        emailButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        printButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }
}
