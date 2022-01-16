package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table( name = "teams" )
public class Team implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_team", nullable = false )
    private int    idTeam;
    @Column( name = "team_name", nullable = false, length = 60 )
    private String teamName;

    @OneToMany( mappedBy = "team", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
    private Collection<User> user;

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam( int idTeam ) {
        this.idTeam = idTeam;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName( String teamName ) {
        this.teamName = teamName;
    }

    public Collection<User> getUser() {
        return user;
    }

    public void setUser( Collection<User> user ) {
        this.user = user;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Team team = (Team) o;
        return idTeam == team.idTeam && teamName.equals( team.teamName ) && Objects.equals( user, team.user );
    }

    @Override public int hashCode() {
        return Objects.hash( idTeam, teamName, user );
    }
}
