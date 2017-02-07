package com.stayrascal.api.users.v1.repositories;

import com.stayrascal.api.users.v1.domain.Movie;
import com.stayrascal.api.users.v1.domain.Person;
import com.stayrascal.api.users.v1.domain.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class MovieRepositoryTest {

    @Autowired
    private Session session;

    @Autowired
    private MovieRepository instance;

    @Autowired
    private PersonRepository personRepository;


    @Before
    public void setUp() throws Exception {
        Movie matrix = new Movie("The Matrix", 1999);
        instance.save(matrix);

        Person keanu = new Person("Keanu Reeves");
        personRepository.save(keanu);

        Role neo = new Role(keanu, matrix);
        neo.addRoleName("Neo");

        matrix.addRole(neo);

        instance.save(matrix);
    }

    @After
    public void tearDown() throws Exception {
        session.purgeDatabase();
    }

    @Test
    public void testFindByTitle() throws Exception {
        String title = "The Matrix";
        Movie result = instance.findByTitle(title);
        assertNotNull(result);
        assertEquals(1999, result.getReleased());
    }

    @Test
    public void testGraph() throws Exception {
        Collection<Movie> graph = instance.graph(5);

        assertEquals(1, graph.size());

        Movie movie = graph.iterator().next();
        assertEquals(1, movie.getRoles().size());
        assertEquals("The Matrix", movie.getTitle());
        assertEquals("Keanu Reeves", movie.getRoles().iterator().next().getPerson().getName());
    }
}