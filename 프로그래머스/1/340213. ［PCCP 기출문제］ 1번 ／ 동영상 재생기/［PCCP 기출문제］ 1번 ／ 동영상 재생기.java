class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        String[] video = video_len.split(":");
        String[] position = pos.split(":");
        String[] start = op_start.split(":");
        String[] end = op_end.split(":");
        
        int m_video_len = Integer.parseInt(video[0]) * 60 + Integer.parseInt(video[1]);
        int m_pos = Integer.parseInt(position[0]) * 60 + Integer.parseInt(position[1]);
        int m_op_start = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        int m_op_end = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        
        if(m_pos >= m_op_start && m_pos < m_op_end){
            m_pos = m_op_end;
        }
        
        for(String c : commands){
              
            switch(c){
                case "prev":
                    m_pos = m_pos > 10 ? m_pos - 10 : 0;
                    break;
                case "next":
                    m_pos = m_pos + 10 < m_video_len? m_pos + 10 : m_video_len;
            }
            
            if(m_pos >= m_op_start && m_pos < m_op_end){
                m_pos = m_op_end;
            }   
        }
        
        String hour = m_pos/60 < 10 ? "0" + String.valueOf(m_pos/60) : String.valueOf(m_pos/60);
        String minute = m_pos%60  < 10 ? "0" + String.valueOf(m_pos%60) : String.valueOf(m_pos%60);
        
        return hour + ":" + minute;
    }
    
}