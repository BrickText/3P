package org.elsys.PPP.trip.entity.enums;

public enum Transport {
    AIRPLANE,
    TRAIN,
    BUS;

    public static Transport stringToTransport(String name) {
        if(name.toLowerCase().equals("airplane")) {
            return Transport.AIRPLANE;
        } else if (name.toLowerCase().equals("train")) {
            return Transport.TRAIN;
        }
        return Transport.BUS;
    }
}
