package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em =  emf.createEntityManager();

        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try {
/*            INSERT
              Member member = new Member();
              member.setId(2L);
              member.setName("HelloB");
              em.persist(member);
 */

/*            UPDATE
              Member findMember =  em.find(Member.class, 1L);
              findMember.setName("HelloJPA");
*/

/*            DELETE
              em.remove();
 */
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for(Member member : result) {
//                System.out.println(member.getName());


//            }

//            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

//            //영속
//            System.out.println("========BEFORE=======");
//            em.persist(member); //1차 캐시에 저장
//            System.out.println("========AFTER==========");

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            System.out.println("===================");
//            em.persist(member1);
//            em.persist(member2);


//            Member member = new Member(200L,"member200");
//            em.persist(member);
//
//            em.flush();

            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            //영속 -> 준영속
            em.detach(member); //특정 엔티티만
            em.clear(); //완전히 초기화
            em.close(); // 종료


            System.out.println("===============");

//            System.out.println("findMember.id = " + findMember.getId() );
//            System.out.println("findMember.name = " + findMember.getName());

            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
