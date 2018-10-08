package com.company.Excersise3;

public class ConcreteCourier extends Thread implements Courier {

    private Dispatcher dispatcher;
    private String couriersName;
    private String sendersDetails;
    private String recipientsDetails;
    private CourierStatus courierStatus;

    public CourierStatus getCourierStatus() {
        return courierStatus;
    }

    public ConcreteCourier(Dispatcher dispatcher, String couriersName) {
        this.dispatcher = dispatcher;
        this.couriersName = couriersName;
        courierStatus = CourierStatus.WAITING_FOR_FIRST_ORDER;
    }

    @Override
    public void realizeOrder(String sendersDetails, String recipientsDetails) {
        this.sendersDetails = sendersDetails;
        this.recipientsDetails= recipientsDetails;
        start();
    }

    @Override
    public void run() {
        courierStatus = CourierStatus.DURING_ORDER;
        System.out.println(couriersName + " picks-up parcel at " + sendersDetails);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(couriersName + " leaves parcel at " + recipientsDetails);
        System.out.println();
        courierStatus = CourierStatus.WAITING_FOR_FIRST_ORDER;
    }
}
