package org.igreenhouse.service;

import org.igreenhouse.domain.DataIn;
import org.igreenhouse.domain.DataOut;
import org.igreenhouse.domain.Indoor;
import org.igreenhouse.domain.Outdoor;
import org.igreenhouse.helper.DatabaseHelper;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by AllenKO on 2015/12/2.
 */
public class DataProcessService {
    public static Indoor indoorDataProcess() {
        String sql = "SELECT * FROM datain ORDER BY uid DESC LIMIT 10";
        List<DataIn> dataIn = DatabaseHelper.queryEntityList(DataIn.class, sql);
        if(0==dataIn.size()){
            return new Indoor(new Timestamp(0), 0, 0, 0, 0, 0);
        }
        float[] total = new float[5];
        float[] average = new float[total.length];
        for (DataIn datain : dataIn) {
            total[0] = total[0] + datain.getAirtemp();
            total[1] = total[1] + datain.getAirhum();
            total[2] = total[2] + datain.getSoiltemp();
            total[3] = total[3] + datain.getSoilhum();
            total[4] = total[4] + datain.getLight();
        }
        int length = dataIn.size();
        for (int i = 0; i < total.length; i++) {
            average[i] = total[i] / length;
        }
        return new Indoor(new Timestamp(System.currentTimeMillis()), average[0], average[1], average[2], average[3], average[4]);
    }

    public static Outdoor outdoorDataProcess() {
        String sql = "SELECT * FROM dataout ORDER BY uid DESC LIMIT 10";
        List<DataOut> dataOut = DatabaseHelper.queryEntityList(DataOut.class, sql);
        if(0==dataOut.size()){
            return new Outdoor(new Timestamp(0), 0, 0, 0, 0, 0,0);
        }
        float[] total = new float[6];
        float[] average = new float[total.length];
        for (DataOut dataout : dataOut) {
            total[0] = total[0] + dataout.getAirtemp();
            total[1] = total[1] + dataout.getAirhum();
            total[2] = total[2] + dataout.getWinddirect();
            total[3] = total[3] + dataout.getWindspeed();
            total[4] = total[4] + dataout.getAtmosphere();
            total[5] = total[5] + dataout.getRainfall();
        }
        int length = dataOut.size();
        for (int i = 0; i < total.length; i++) {
            average[i] = total[i] / length;
        }
        return new Outdoor(new Timestamp(System.currentTimeMillis()), average[0], average[1], average[2], average[3], average[4], average[5]);
    }
}
