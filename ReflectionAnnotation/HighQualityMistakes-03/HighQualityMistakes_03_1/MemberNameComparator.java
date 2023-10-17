package HighQualityMistakes_03_1;

import java.lang.reflect.Member;
import java.util.Comparator;

// members by name
public class MemberNameComparator implements Comparator<Member> {

    @Override
    public int compare(Member f, Member s) {
        return f.getName().compareTo(s.getName());
    }

}
