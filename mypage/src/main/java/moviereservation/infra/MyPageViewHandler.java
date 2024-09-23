package moviereservation.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import moviereservation.config.kafka.KafkaProcessor;
import moviereservation.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MyPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenMoviereserved_then_CREATE_1(
        @Payload Moviereserved moviereserved
    ) {
        try {
            if (!moviereserved.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setUserId(Long.valueOf(moviereserved.getUserId()));
            myPage.setQty(moviereserved.getQty());
            myPage.setMovieTitle(moviereserved.getMovieTitle());
            myPage.setReserveDt(Date.valueOf(moviereserved.getReservationId()));
            myPage.setReserveDt(moviereserved.getReserveDt());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenMoviereserved_then_UPDATE_1(
        @Payload Moviereserved moviereserved
    ) {
        try {
            if (!moviereserved.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByUserId(
                Long.valueOf(moviereserved.getUserId())
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setUserId(Long.valueOf(moviereserved.getUserId()));
                myPage.setQty(myPage.getQty() + moviereserved.getQty());
                myPage.setMovieTitle(moviereserved.getMovieTitle());
                myPage.setReservationId(moviereserved.getReservationId());
                myPage.setReserveDt(moviereserved.getReserveDt());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenMoviereservationcanceled_then_DELETE_1(
        @Payload Moviereservationcanceled moviereservationcanceled
    ) {
        try {
            if (!moviereservationcanceled.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            myPageRepository.deleteByUserId(
                Long.valueOf(moviereservationcanceled.getUserId())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
