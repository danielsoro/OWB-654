package owb;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StringBeanAbstract extends MyAbstract<String>
{
    @Override
    public String getValue()
    {
        return getClass().getName();
    }
}
